# Martian Robots

Martian Robots is a Java application that simulates the movement of robots on a grid-based map. The robots follow a set of instructions and move within the specified grid boundaries.

## Requirements

To run the application, you need the following:

- Java Development Kit (JDK) 8 or above
- Maven

## Usage
1. Mark the Pom.xml file as a maven project
2. Navigate to the entrypoint of the application (Main.java).
3. Execute the main method.
4. Sample input below : (First line Grid Size, every following pair is the robots initial configuration (coordinates and orientation) and a list of instructions)

## Sample Input

````
5 3 
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL
````

## Expected Output  

````
1 1 E
3 3 N LOST
2 3 S
````