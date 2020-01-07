package com.shatteredpixel.shatteredpixeldungeon.levels.rooms.special;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.IronKey;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class DepressiveRoom extends SpecialRoom {

    public void paint(Level level){

        Painter.fill(level, this, Terrain.EMPTY);


        Door entrance = entrance();

        entrance.set( Door.Type.LOCKED );

        level.addItemToSpawn( new IronKey( Dungeon.depth ));

    }

}
