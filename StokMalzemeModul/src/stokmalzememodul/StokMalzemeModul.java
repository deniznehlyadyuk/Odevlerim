package stokmalzememodul;

import stokmalzememodul.Forms.AnaForm;

public class StokMalzemeModul {
    public static void main(String[] args) throws ClassNotFoundException {
        Database.Connect();
        
        AnaForm form = new AnaForm();
        form.setVisible(true);
    }
    
}
