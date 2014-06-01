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

import com.jogamp.opengl.util.*;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import thebounzer.org.oglplayground.physics.HarmonicMotion;
/**
 *
 * @author thbounzer
 */
public class OpenglPlayground implements GLEventListener{
    
    public static int width = 600;
    public static int height = 600;
    public static double pixWidth = 1/width;
    
    private static final double mass = 0.9;
    private static final double stiff = 0.5;
    private static final int fps = 60;
    HarmonicMotion hm = new HarmonicMotion(mass, stiff);
    
    public static void main(String[] args) {
            GLProfile glp = GLProfile.getDefault();
            GLCapabilities caps = new GLCapabilities(glp);
            
            // Uhm, don't know what this does. Include it or antialiasing will not work!
            caps.setSampleBuffers(true);
            caps.setNumSamples(3);
            
            GLCanvas canvas = new GLCanvas(caps);
            Frame frame = new Frame("Yourtitle");
            frame.setSize(width, height);
            frame.add(canvas);
            frame.setVisible(true);
            

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            canvas.addGLEventListener(new OpenglPlayground());
            FPSAnimator animator = new FPSAnimator(canvas,fps);  
            animator.start();

        }    

        @Override
        public void init(GLAutoDrawable drawable) {
            GL2 gl = drawable.getGL().getGL2();
            gl.glEnable(GL2.GL_LINE_SMOOTH);
            gl.glEnable(GL2.GL_BLEND);
            gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
            gl.glHint(GL2.GL_LINE_SMOOTH_HINT, GL2.GL_NICEST);
            gl.glShadeModel(GL2.GL_SMOOTH);
            
            
        }

        @Override
        public void dispose(GLAutoDrawable drawable) {

        }

        @Override
        public void display(GLAutoDrawable drawable) {
            render(drawable);
            
        }

        @Override
        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }


        private void render(GLAutoDrawable drawable) {
            GL2 gl = drawable.getGL().getGL2();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glBegin(GL2.GL_LINES);
            double endPos = hm.motionize(0.05);
            gl.glColor3fv(ColorBufferFactory.green());
            gl.glVertex2d(0.0, 0.0);
            gl.glVertex2d(endPos,0.0);
            gl.glEnd();
            gl.glBegin(GL2.GL_LINE_LOOP);
            PrimitiveShapes.circle(width, height, 0, 0, 10, 30, ColorBufferFactory.red(), gl);
            gl.glEnd();
            gl.glBegin(GL2.GL_LINE_LOOP);
            PrimitiveShapes.circle(width, height, endPos, 0, 15, 30, ColorBufferFactory.blue(), gl);
            gl.glEnd();            
            

        } 
}
