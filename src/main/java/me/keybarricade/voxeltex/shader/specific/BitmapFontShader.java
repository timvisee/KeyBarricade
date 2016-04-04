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

package me.keybarricade.voxeltex.shader.specific;

import me.keybarricade.voxeltex.material.Material;
import me.keybarricade.voxeltex.scene.AbstractScene;
import me.keybarricade.voxeltex.shader.Shader;
import me.keybarricade.voxeltex.shader.raw.AbstractRawShader;
import me.keybarricade.voxeltex.shader.raw.EngineAssetsRawShader;

public class BitmapFontShader extends Shader {

    /**
     * The engine asset path of the vertex shader.
     */
    private static final String SHADER_VERTEX_ASSET_PATH = "shaders/bitmapFont.vert";

    /**
     * The engine asset path of the fragment shader.
     */
    private static final String SHADER_FRAGMENT_ASSET_PATH = "shaders/bitmapFont.frag";

    /**
     * Constructor.
     */
    public BitmapFontShader() {
        this(new EngineAssetsRawShader(SHADER_VERTEX_ASSET_PATH, SHADER_FRAGMENT_ASSET_PATH));
    }

    /**
     * Constructor.
     *
     * @param programId OpenGL shader program ID.
     */
    public BitmapFontShader(int programId) {
        super(programId);
    }

    /**
     * Constructor.
     *
     * @param rawShader Raw shader.
     */
    public BitmapFontShader(AbstractRawShader rawShader) {
        super(rawShader);
    }

    @Override
    public void update(AbstractScene scene, Material material) {
        // Call the parent
        super.update(scene, material);

        // Send texture tiling data to the shader
        if(material != null)
            setUniform2f("tiling", material.getTiling());
    }
}
