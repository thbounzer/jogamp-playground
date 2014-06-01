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

package thebounzer.org.oglplayground.physics;

/**
 *
 * @author thbounzer
 */
public class HarmonicMotion {
    
    private double massObj;
    private double stiffnessObj; 
    private final static int numberOfparams = 3;    
    private double[] parameters = new double[numberOfparams];
    private final static int positionX = 1;
    private final static int velocityX = 2;    
    //private double endPositionX = 0.0;
    
    public HarmonicMotion(double mass, double stiffness){
        massObj = mass;
        stiffnessObj = stiffness;
        parameters[positionX] = 0.3;
    }
    
    

    
    public double motionize(double i_dt){
        //Compute acceleration value from current position
        double A = (-stiffnessObj/massObj) * parameters[positionX];
        
        // Update velocity based on acceleration.
        parameters[velocityX] += i_dt * A;

        // Update position based on current velocity.
        parameters[positionX] += i_dt * parameters[velocityX];

        
     
        return parameters[positionX];
    }
    
}
