using System;

public class PocketObject {
    private int id { get; set; }
    private bool isLost { get ; set; }

    public PocketObject(int ident){
        id = ident;
        isLost = false;
    }

}