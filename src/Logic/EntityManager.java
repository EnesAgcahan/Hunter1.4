
package Logic;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> rederSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
                return -1;
            }else{
                return  1;
            }
        }
    };
    
    public EntityManager(Handler handler ,Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }
    
    public void tick(){
    Iterator<Entity> it = entities.iterator();
    while(it.hasNext()) {
            Entity e = it.next();
            e.tick();
            if (!e.isActive()) {
               it.remove();
            }
        }
        entities.sort(rederSorter);

    }
    
    public void render(Graphics g){
        for (Entity e : entities) {
            e.render(g);
        }
        player.postRender(g);
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }

    
    //Getter-Setter
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    
    
}
