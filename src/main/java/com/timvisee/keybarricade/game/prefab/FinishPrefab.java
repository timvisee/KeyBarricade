/******************************************************************************
 * Copyright (c) Tim Visee 2016. All rights reserved.                         *
 *                                                                            *
 * @author Tim Visee                                                          *
 * @website http://timvisee.com/                                              *
 *                                                                            *
 * Open Source != No Copyright                                                *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * You should have received a copy of The MIT License (MIT) along with this   *
 * program. If not, see <http://opensource.org/licenses/MIT/>.                *
 ******************************************************************************/

package com.timvisee.keybarricade.game.prefab;

import com.timvisee.keybarricade.game.asset.GameResourceBundle;
import com.timvisee.keybarricade.game.component.player.PlayerControllerComponent;
import com.timvisee.voxeltex.prefab.primitive.QuadPrefab;

public class FinishPrefab extends QuadPrefab {

    /**
     * Game object name.
     */
    private static final String GAME_OBJECT_NAME = "FinishPrefab";

    /**
     * Distance trigger.
     */
    private static final float PICKUP_TRIGGER_DISTANCE = 0.5f;

    /**
     * Reference to player controller component. Used to calculate whether to pickup the key or not.
     */
    private PlayerControllerComponent playerController;

    /**
     * Flag to ensure the finish is only triggered once.
     */
    private boolean triggered = false;

    /**
     * Constructor.
     */
    public FinishPrefab() {
        this(GAME_OBJECT_NAME, null);
    }

    /**
     * Constructor.
     *
     * @param playerController Player reference.
     */
    public FinishPrefab(PlayerControllerComponent playerController) {
        this(GAME_OBJECT_NAME, playerController);
    }

    /**
     * Constructor.
     *
     * @param name Game object name.
     * @param playerController Player controller component reference.
     */
    public FinishPrefab(String name, PlayerControllerComponent playerController) {
        // Construct the parent with the proper size
        super(name);

        // Set the player controller component reference
        this.playerController = playerController;

        // Set the finish material
        setMaterial(GameResourceBundle.getInstance().MATERIAL_FINISH);
    }

    @Override
    public synchronized void update() {
        // Call the super
        super.update();

        // Make sure the finish hasn't been triggered before
        if(this.triggered)
            return;

        // Make sure a player controller reference is given
        if(this.playerController != null && this.playerController.getOwner() != null) {
            // Calculate the distance (squared) to the player controller
            float distance = this.playerController.getTransform().getPosition().distanceSquared(getTransform().getPosition());

            // Determine whether to pickup the item, trigger the player controller if that's the case
            if(distance <= PICKUP_TRIGGER_DISTANCE * PICKUP_TRIGGER_DISTANCE) {
                // Set the triggered flag
                this.triggered = true;

                // Trigger the player controller
                this.playerController.onTrigger(this);
            }
        }
    }
}
