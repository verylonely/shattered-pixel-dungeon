package com.shatteredpixel.shatteredpixeldungeon.ui.changelist;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Wanderer;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Chopper;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.ChangesScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.Image;

import java.util.ArrayList;

public class v0_8_X_Changes {

    public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){

        add_v_0_8(changeInfos);

    }

    public static void add_v_0_8( ArrayList<ChangeInfo> changeInfos ){

        ChangeInfo changes = new ChangeInfo("v0.8", true, "");
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes = new ChangeInfo(Messages.get(ChangesScene.class, "new"), false, null);
        changes.hardlight(Window.GPD_COLOR);
        changeInfos.add(changes);

        changes.addButton( new ChangeButton( new Image(Assets.ITEMS,0 , 528, 16, 16),
                Messages.get(Chopper.class, "name"), "New weapon"));

        changes.addButton( new ChangeButton( new Image(Assets.WANDERER, 0, 0, 16, 16),
                Messages.get(Wanderer.class, "name"), "New neutral mob" ));

    }

}
