package GraphicsElements;

import java.awt.Color;
import java.awt.Rectangle;

public class ColorRectangle extends Rectangle{
	private Color c;

    public Color getColor() {
        return c;
    }

    public boolean setColor( Color c ) {
        boolean rtn = false;
        if( c != null ) {
            this.c = c;
            rtn = true;
        }

        return rtn;
    }
    
    public ColorRectangle() {}
    
    public ColorRectangle(Color c) {
    	super();
        this.c = c;
    }
}
