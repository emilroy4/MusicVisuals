package c21716601;

import processing.core.PApplet;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    float angle = 0.0f;
    float width = 800f;
    float height = 800f;

    public void render() {

        // CUBES

        float interval = 2000; // alternate colors every 2 seconds
        float currentTime = nico.millis();
        
        if (currentTime % interval < interval / 2) {
            nico.fill(255); // set the fill color to white
            nico.stroke(255, 0, 0); // set stroke to red
        } else {
          nico.fill(255, 0, 0); // set the fill color to red
          nico.stroke(255); // set stroke white
        }

        nico.strokeWeight(5); // set the stroke thickness to 5 pixels
        nico.pushMatrix(); // save the current transformation
        nico.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(-90, 0, 0); // move the cube to the left
        nico.rotateX(angle); // rotate the cube around the y-axis
        nico.box(40); // draw the cube
        nico.popMatrix(); // restore the previous transformation
        
        nico.pushMatrix(); // save the current transformation
        nico.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(90, 0, 0); // move the cube to the right
        nico.rotateX(angle); // rotate the cube around the x-axis
        nico.box(40); // draw the cube
        nico.popMatrix(); // restore the previous transformation
        
        // SPHERE

        nico.camera(0, -100, 200, 0, 0, 0, 5, 0, 0);
        nico.translate(0, 0);
        nico.strokeWeight(1); // set the stroke thickness to 2 pixels
        nico.rotateZ((float) (angle + Math.PI / 2)); // rotate the sphere around the Z-axis by 90 degrees
        float[] b = nico.getSmoothedBands();

        // Map the value of b[2] to a range between 0 and 1
        float mappedValue = nico.map(b[2], 0, 255, 0, 1);

        // Scale the value of the sphere based on the mapped value
        float size = 80 * mappedValue;
        size = Math.min(size, 70); // limit the maximum height of the sphere to 70 pixels

        nico.pushMatrix();
        nico.translate(0, 0, 0); // move the sphere to the center of the screen
        nico.fill(255, 0, 0); // set the fill color to red
        nico.stroke(255); // set stroke white
        nico.sphere(size); // draw a sphere with a diameter of 'size'
        nico.popMatrix();

        angle += 0.01; // increment the rotation angle

        // SHOOTING STARS
        // Call shootingStars method
        shootingStars();

    }

    // New shootingStars method
    public void shootingStars() {
        nico.randomSeed(1);
        for (int i = 0; i < 100; i++) {
            nico.stroke(255, 0 ,0); // set the stroke color to red
            nico.strokeWeight(nico.random(2, 5)); // set a random stroke weight between 2 and 5 pixels
            nico.point(nico.random(-width / 2, width / 2), nico.random(-height / 2, height / 2),
                    nico.random(-500, 500));
        }
    }

}