# Mars Rover

## Project Overview

The Mars Rover Kata is a coding challenge that simulates controlling a rover on the surface of Mars. This project provides an API that translates commands sent from Earth into instructions understood by the rover. The rover can move forward, backward, turn, wrap around the surface edges, and detect obstacles, stopping before collisions.

## Features

- **Movement Commands**: The rover responds to `f` (forward) and `b` (backward) commands.
- **Turning Commands**: The rover can turn left (`l`) or right (`r`).
- **Edge Wrapping**: The rover wraps around when reaching grid edges.
- **Obstacle Detection**: If an obstacle is detected in the path, the rover stops and reports the position of the obstacle.

## Technologies Used

- Java (JDK 21)
- JUnit 4.13.2 for testing

## Getting Started

### Prerequisites

Ensure you have the following installed:
- **Java JDK** (version 21 or higher)
- **Maven** (for dependency management and running tests)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/maboulfadle/mars-rover.git
   cd mars-rover
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the tests**:
   ```bash
   mvn test
   ```

## Project Structure

- **`Rover`**: The main class representing the rover. Handles commands, movement, edge wrapping, and obstacle detection.
- **`Direction`**: Enum for handling rover orientation (NORTH, EAST, SOUTH, WEST).
- **`Command`**: Enum for handling rover instructions (forward, backward, left, right).
- **`Surface`**: Class representing the surface where the rover dropped-in.
- **`Position`**: Class representing the rover’s position on the surface.
- **`RoverTest`**: Contains unit tests for verify the functionalities of the rover class.
- **`PositionTest`**: Contains unit tests to verify the functionalities of the rover position class.

## Usage

To use the Rover API, create an instance of `Rover`, specify the initial position, direction, grid size, and any obstacles. Then, use the `executeCommands` method to send a command string to the rover.

### Command Details

- **f**: Move forward in the current direction.
- **b**: Move backward in the current direction.
- **l**: Turn left.
- **r**: Turn right.

### Edge Wrapping Example

- Moving north from the top edge wraps to the bottom.
- Moving west from the left edge wraps to the right.

### Obstacle Detection

If the rover encounters an obstacle, it stops before reaching it and reports the obstacle's position and direction.

## Running Tests

The project includes a set of JUnit tests for verifying functionality and edge cases in the `RoverTest` class. To run the tests, execute:

```bash
mvn test
```

## Design Decisions

This solution is structured to separate core responsibilities:
- **Movement**: Handled by `Position`.
- **Direction, Edge Wrapping and Obstacle Detection**: Managed within `Rover`, keeping the movement and boundary logic centralized.

## License

This project is open-source and available under the MIT License.
