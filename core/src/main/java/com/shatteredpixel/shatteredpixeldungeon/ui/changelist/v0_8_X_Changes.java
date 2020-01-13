package com.shatteredpixel.shatteredpixeldungeon.ui.changelist;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Roomless;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Wanderer;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Zombie;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Chopper;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.ChangesScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.Image;

import java.util.ArrayList;

public class v0_8_X_Changes {

    public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){

        add_v_0_8_1(changeInfos);
        add_v_0_8(changeInfos);

    }

    public static void add_v_0_8_1(ArrayList<ChangeInfo> changeInfos){
        ChangeInfo changes = new ChangeInfo("v0.8.1", true, "");
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo(Messages.get(ChangesScene.class, "new"),
                false, null);

        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton( new Image( Assets.ZOMBIE,
                0, 0, 12, 16), Messages.get(Zombie.class, "name"),
                "New angry mob\nDesign based on old heroes") );

        changes.addButton( new ChangeButton( new Image(Assets.WARRIOR,
                0,15, 12, 15), "New Heroes!",
                "New look for 4 main characters") );

        changes.addButton( new ChangeButton( new Image(Assets.ICONS_GLOOMY,
                0, 0, 16, 16), "Banners update",
                "With this release, new banner textures are also coming."));

        changes = new ChangeInfo(Messages.get(ChangesScene.class, "changes"), false, null);
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton( new Image( Assets.ROOMLESS,
                0, 0, 12, 16), Messages.get(Roomless.class, "name"),
                "Parameters Depend on Depth(Attack Skill, Defense Skill") );
    }

    public static void add_v_0_8( ArrayList<ChangeInfo> changeInfos ){

        ChangeInfo changes = new ChangeInfo("v0.8", true, "");
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo(Messages.get(ChangesScene.class, "new"),
                false, null);

        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton( new Image(Assets.ITEMS,0 , 528, 16, 16),
                Messages.get(Chopper.class, "name"), "New weapon"));

        changes.addButton( new ChangeButton( new Image(Assets.WANDERER, 0, 0, 16, 16),
                Messages.get(Wanderer.class, "name"), "New neutral mob" ));

        changes = new ChangeInfo(Messages.get(ChangesScene.class, "bugfixes"),
                false, null);
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton( new Image(Assets.ICONS,
                0, 64, 16, 16), "Rooms generator",
                "Fixed crash when generating rooms." ) );

    }

}
