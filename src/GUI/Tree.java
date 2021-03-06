
package GUI;

import Logic.Handler;
import Logic.StaticEntity;
import java.awt.Graphics;

public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y,Tile.TILEWIDHT,Tile.TILEHEIGHT *2);
        
        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.crateNew((int) x,(int) y));
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
    }
    
}
