package stokmalzememodul;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import stokmalzememodul.Interfaces.IOperations2;
import stokmalzememodul.Interfaces.IOperations3;

final public class Malzeme implements IOperations2, IOperations3
{
    private int Id;
    private String Ad;
    private String Marka;
    private String Model;
    private double Agirlik;
    private double Fiyat;
    
    public Malzeme(String ad, String marka, String model, double agirlik, double fiyat) 
    {
        Ad = ad;
        Marka = marka;
        Model = model;
        Agirlik = agirlik;
        Fiyat = fiyat;
    }

    public Malzeme(String ad, String marka, double agirlik, double fiyat) 
    {
        Ad = ad;
        Marka = marka;
        Model = "";
        Agirlik = agirlik;
        Fiyat = fiyat;
    }

    public Malzeme(int id) {
        String query = "SELECT * FROM malzeme WHERE MalzemeId = "+id;
        ResultSet bilgiler = Database.RunSelectQuery(query);
        try {
            bilgiler.next();
            Id = id;
            Ad = bilgiler.getString(2);
            Marka = bilgiler.getString(3);
            Model = bilgiler.getString(4);
            Agirlik = bilgiler.getInt(5);
            Fiyat = bilgiler.getInt(6);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public Malzeme() {
        Id = -1;
        Ad = "";
        Marka = "";
        Model = "";
        Agirlik = 0;
        Fiyat = 0;
    }
    
    public void SetId(int id)
    {
        Id = id;
    }
    
    public void SetAd(String ad) 
    {
        Ad = ad;
    }

    public void SetMarka(String marka) 
    {
        Marka = marka;
    }

    public void SetModel(String model) 
    {
        Model = model;
    }

    public void SetAgirlik(double agirlik) 
    {
        Agirlik = agirlik;
    }

    public void SetFiyat(double fiyat) 
    {
        Fiyat = fiyat;
    }
    
    public int GetId() 
    {
        return Id;
    }
    
    public String GetAd() 
    {
        return Ad;
    }

    public String GetMarka() 
    {
        return Marka;
    }

    public String GetModel()
    {
        return Model;
    }

    public double GetAgirlik() 
    {
        return Agirlik;
    }

    public double GetFiyat() 
    {
        return Fiyat;
    }
    
    public void Ekle() 
    {
        if (!Database.IsConnected()) {
            System.out.println("Veritabanı ile bağlantı kurulamadı.");
            return;
        }
        String MalzemeBilgiler = "'"+Ad+"', '"+Marka+"', '"+Model+"', "+Agirlik+
                                 ", "+Fiyat+"";
        Database.RunUpdateQuery("INSERT INTO malzeme (MalzemeAd, MalzemeMarka, "
                + "MalzemeModel, MalzemeAgirlik, MalzemeFiyat) values"
                + "("+MalzemeBilgiler+")");
        ResultSet IdRow = Database.RunSelectQuery("SELECT MalzemeId FROM "
                + "stoktakip.malzeme ORDER BY MalzemeId DESC LIMIT 1;");
        try {
            IdRow.next();
            Id = IdRow.getInt(1);
        } catch(Exception e){
            
        }
    }
    
    private String AramaQueryOlustur() {
        boolean queryGuncellendiMi = false;
        String query = "SELECT * FROM malzeme WHERE ";
        
        if (Ad != "") {
            query += "MalzemeAd = '"+Ad+"' AND ";
            queryGuncellendiMi = true;
        }
        if (Marka != "") {
            query += "MalzemeMarka = '"+Marka+"' AND ";
            queryGuncellendiMi = true;
        }
        if (Model != "") {
            query += "MalzemeModel = '"+Model+"' AND ";
            queryGuncellendiMi = true;
        }
        if (Agirlik != 0) {
            query += "MalzemeAgirlik = "+Agirlik+" AND ";
            queryGuncellendiMi = true;
        }
        if (Fiyat != 0) {
            query += "MalzemeFiyat = "+Fiyat;
        }
        else if (queryGuncellendiMi) {
            query = query.substring(0, query.length()-4);
        }
        
        return query;
    }
    
    public List<Malzeme> Listele()
    {
        if (!Database.IsConnected()) {
            System.out.println("Veritabanı ile bağlantı kurulamadı.");
            return null;
        }
        
        String query = "SELECT * FROM malzeme";
        ResultSet bulunanlar = Database.RunSelectQuery(query);
        
        try {
            List<Malzeme> Malzemeler = new ArrayList<Malzeme>();
            while (bulunanlar.next()) {
                Id = bulunanlar.getInt(1);
                Ad = bulunanlar.getString(2);
                Marka = bulunanlar.getString(3);
                Model = bulunanlar.getString(4);
                Agirlik = bulunanlar.getDouble(5);
                Fiyat = bulunanlar.getDouble(6);
                
                Malzeme malzeme = new Malzeme(Ad, Marka, Model, Agirlik, Fiyat);
                malzeme.SetId(Id);
                
                Malzemeler.add(malzeme);
            }
            
            return Malzemeler;
        } catch(Exception e) {
            return null;
        }   
        
    }
    public List<Malzeme> Ara()
    {
        if (!Database.IsConnected()) {
            System.out.println("Veritabanı ile bağlantı kurulamadı.");
            return null;
        }
        
        String query = AramaQueryOlustur();
        ResultSet bulunanlar = Database.RunSelectQuery(query);
        
        try {
            List<Malzeme> bulunanMalzemelerList = new ArrayList<Malzeme>();
            int index = 0;
            while (bulunanlar.next()) {
                Id = bulunanlar.getInt(1);
                Ad = bulunanlar.getString(2);
                Marka = bulunanlar.getString(3);
                Model = bulunanlar.getString(4);
                Agirlik = bulunanlar.getDouble(5);
                Fiyat = bulunanlar.getDouble(6);
                
                Malzeme malzeme = new Malzeme(Ad, Marka, Model, Agirlik, Fiyat);
                malzeme.SetId(Id);
                
                bulunanMalzemelerList.add(malzeme);
            }            
            return bulunanMalzemelerList;
        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public void Guncelle()
    {
        if (!Database.IsConnected()) {
            System.out.println("Veritabanı ile bağlantı kurulamadı.");
            return;
        }
        String query = "UPDATE malzeme SET MalzemeAd = '"+Ad+"', MalzemeMarka = '"+
                       Marka+"', MalzemeModel = '"+Model+"', MalzemeAgirlik = "+
                       Agirlik+", MalzemeFiyat = "+Fiyat+" WHERE MalzemeId = "+Id;
        Database.RunUpdateQuery(query);
    }
    public void Sil()
    {
        if (!Database.IsConnected()) {
            System.out.println("Veritabanı ile bağlantı kurulamadı.");
            return;
        }
        String query = "DELETE from malzeme WHERE MalzemeId = "+Id;
        Database.RunUpdateQuery(query);
    }
}