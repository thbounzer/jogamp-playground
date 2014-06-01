/*
 * The MIT License
 *
 * Copyright 2014 thbounzer.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package thebounzer.org.oglplayground;


import java.nio.FloatBuffer;

/**
 *
 * @author thbounzer
 */
public class ColorBufferFactory {
    
    private final static int R = 0;
    private final static int G = 1;
    private final static int B = 2;

       
    public static FloatBuffer red(){
        return colorCompsAss(1, 0, 0);
    }
    
    public static FloatBuffer green(){
        return colorCompsAss(0, 1, 0);
    }
    
    public static FloatBuffer blue(){
        return colorCompsAss(0, 0, 1);
    }
    
    private static FloatBuffer colorCompsAss(float r, float g, float b){
        float[] color = new float[3];
        color[R] = r;
        color[G] = g;
        color[B] = b;
        return FloatBuffer.wrap(color);
    }
}
