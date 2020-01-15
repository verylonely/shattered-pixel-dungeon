/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * Gloomy Pixel Dungeon
 * Copyright (C) 2019-2020 Kirill Semykin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.scenes;

import com.shatteredpixel.shatteredpixeldungeon.SPDSettings;
import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.Flare;
import com.shatteredpixel.shatteredpixeldungeon.ui.Archs;
import com.shatteredpixel.shatteredpixeldungeon.ui.ExitButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons_Gloomy;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.input.PointerEvent;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Image;
import com.watabou.noosa.PointerArea;
import com.watabou.utils.DeviceCompat;

public class AboutScene extends PixelScene {

	private static final String TTL_GPD = "Gloomy Pixel Dungeon";

	private static final String TXT_GPD =
			"Code & Graphics: VeryLonely\n" +
			"Design & Graphics: Yorkie-";

	private static final String FORKED	= "Based on:";

	private static final String TTL_SHPX = "Shattered Pixel Dungeon";

	private static final String TXT_SHPX =
			"Design, Code, & Graphics: Evan";

	private static final String LNK_SHPX = "ShatteredPixel.com";

	private static final String TTL_WATA = "Pixel Dungeon";

	private static final String TXT_WATA =
			"Code & Graphics: Watabou\n" +
			"Music: Cube_Code";
	
	private static final String LNK_WATA = "pixeldungeon.watabou.ru";
	
	@Override
	public void create() {
		super.create();

		final float colWidth = Camera.main.width / (SPDSettings.landscape() ? 2 : 1);
		final float colTop = (Camera.main.height / 2) - (SPDSettings.landscape() ? 30 : 90);

		//------------------------------------------------------------------------------------------

		Image gpd = Icons_Gloomy.GPD.get();
		gpd.x = (colWidth - gpd.width()) / 2;
		gpd.y = colTop;
		align(gpd);
		add( gpd );



		RenderedTextBlock gpdtitle = renderTextBlock(TTL_GPD, 8);
		gpdtitle.hardlight( Window.GPD_COLOR );
		add( gpdtitle );

		gpdtitle.setPos(
				(colWidth - gpdtitle.width()) / 2,
				gpd.y + gpd.height + 5
		);

			if(SPDSettings.landscape()){
				gpd.x = colWidth - gpd.width() + (gpd.width() / 2);
				gpd.y = colTop / 2;
				gpdtitle.setPos(
						(colWidth - gpdtitle.width()) + (gpdtitle.width() / 2),
						gpd.y + gpd.height + 5
				);
			}

		align(gpdtitle);

		RenderedTextBlock gpdtext = renderTextBlock( TXT_GPD, 8);
		gpdtext.maxWidth((int)Math.min(colWidth, 120));
		add( gpdtext );
		gpdtext.setPos((colWidth - gpdtext.width()) / 2, gpdtitle.bottom() + 12);


			if(SPDSettings.landscape()){
				gpdtext.setPos(
						(colWidth - gpdtext.width()) + (gpdtext.width() / 2),
						gpdtitle.bottom() + 12
				);
			}

		align(gpdtext);
		new Flare( 7, 64 ).color( 0xff1800, true ).show( gpd,0 ).angularSpeed = +20;

		RenderedTextBlock forked 	= renderTextBlock(FORKED, 8);
		RenderedTextBlock shpxtitle = renderTextBlock(TTL_SHPX, 8);
		RenderedTextBlock watatitle	= renderTextBlock(TTL_WATA, 8);

		add( forked );
		forked.setPos(
				(colWidth - forked.width()) / 2,
				gpdtext.bottom() + (colTop / 1.5f)
		);

		if(SPDSettings.landscape())
		{
			forked.setPos(
					(colWidth - forked.width()) + (forked.width() / 2),
					gpdtext.bottom() + 12
			);
		}


		align( forked );

		add( shpxtitle );

		shpxtitle.setPos(
				(colWidth - shpxtitle.width()) / 2,
				forked.bottom() + 12
		);

			if(SPDSettings.landscape())
			{
				shpxtitle.setPos(
						(colWidth - shpxtitle.width() + (shpxtitle.width() / 2)) - (colWidth / 4),
						forked.bottom() + 12
				);
			}

		shpxtitle.hardlight(Window.SHPX_COLOR);

		align( shpxtitle );

		add( watatitle );

		watatitle.setPos(
				(colWidth - watatitle.width()) / 2,
				shpxtitle.bottom() + 7
		);

			if(SPDSettings.landscape())
			{
				watatitle.setPos(
						(colWidth - watatitle.width() + (watatitle.width() / 2)) + (colWidth / 4),
						forked.bottom() + 12
				);
			}

		watatitle.hardlight(Window.TITLE_COLOR);

		align( watatitle );



		//------------------------------------------------------------------------------------------



		
		Archs archs = new Archs();
		archs.setSize( Camera.main.width, Camera.main.height );
		addToBack( archs );
		ExitButton btnExit = new ExitButton();
		btnExit.setPos( Camera.main.width - btnExit.width(), 0 );
		add( btnExit );

		fadeIn();
	}
	
	@Override
	protected void onBackPressed() {
		ShatteredPixelDungeon.switchNoFade(TitleScene.class);
	}
}
