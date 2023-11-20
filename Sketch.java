import processing.core.PApplet;
import processing.core.PImage;



public class Sketch extends PApplet {
	
  // Global Variables
  PImage earthBackground;
  PImage moonImage; 

  float fltEarthBackgroundX = 200;
  float fltEarthBackgroundY = 200;

  float fltMoonX = 40;
  float fltMoonY = 40;
  float fltMoonSpeedX = 1;
  float fltMoonSpeedY = 1;
  float fltMoonRadius = 75;
  float fltRadius = 160;
  float fltCurrentAngle;

  float fltAsteroidX = 20;
  float fltAsteroidY = 220;
  float fltAsteroidSpeedX = 1;
  float fltAsteroidSpeedY = 1;
  float fltAsteroidRadius = 25;
  
  public void settings() {
	  // Size of the canvas
    size(400, 400);
  }

 
  public void setup() {
    // Image mode change to center
    imageMode(CENTER);

    // Importing image and resizing
    earthBackground = loadImage("earth_pixelart__by_dylan_smith__by_dylansmith99_dc2oj7k-fullview (1).jpg");
    earthBackground.resize(400, 400);
    
    // Importing image and rezising
    moonImage = loadImage("Moon Image.png");
    moonImage.resize(75, 75);
  }

  public void draw() {
    // Improted images drawn to the screen with global variables.
	  image(earthBackground, fltEarthBackgroundX, fltEarthBackgroundY);
    
    image(moonImage, fltMoonX + fltEarthBackgroundX, fltMoonY + fltEarthBackgroundY);
    
    // Circle asteroid with craters
    noStroke();
    fill(128, 128, 128);
    ellipse(fltAsteroidX, fltAsteroidY, fltAsteroidRadius, fltAsteroidRadius);

    noStroke();
    fill(90);
    ellipse(fltAsteroidX + 8, fltAsteroidY + 2, 5, 5);

    noStroke();
    fill(90);
    ellipse(fltAsteroidX + 2, fltAsteroidY + 7, 5, 5);

    noStroke();
    fill(90);
    ellipse(fltAsteroidX + 3, fltAsteroidY - 7, 5, 5);

    noStroke();
    fill(90);
    ellipse(fltAsteroidX - 6, fltAsteroidY, 5, 5);

    // Basic edge detection and movement of the asteroid.
    fltAsteroidX = fltAsteroidX + fltAsteroidSpeedX;
    fltAsteroidY = fltAsteroidY + fltAsteroidSpeedY;
    
    if(fltAsteroidX < 0 || fltAsteroidX > width) {
      fltAsteroidSpeedX = fltAsteroidSpeedX * -1;
    }

    if(fltAsteroidY < 0 || fltAsteroidY > height) {
      fltAsteroidSpeedY = fltAsteroidSpeedY * -1;
    }

    // Movement of the moon
    fltCurrentAngle += 0.1;
    
    // Movement of the moon in a circular motion based off the given radius.
    fltMoonX = (int) (fltRadius * Math.cos(fltCurrentAngle * Math.PI / 180));
    fltMoonY = (int) (fltRadius * Math.sin(fltCurrentAngle * Math.PI / 180));
   

  }

}