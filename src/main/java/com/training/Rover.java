package com.training;

import static java.lang.String.format;

/**
 * The {@link Rover} class contains the rover related operations.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
public class Rover {

    private final Surface surface;
    private Position position;
    private Direction direction;

    /**
     * Instantiates a new Rover.
     *
     * @param surface   the surface
     * @param position  the position
     * @param direction the direction
     */
    public Rover(final Surface surface, final Position position, final Direction direction) {
        this.surface = surface;
        this.position = position;
        this.direction = direction;
    }

    /**
     * Execute commands.
     *
     * @param commands the commands
     * @return the rover new position and direction after executing the given {@code commands}
     */
    public String executeCommands(final String commands) {
        for (final char c : commands.toCharArray()) {
            final Command command = Command.fromSymbol(c);
            switch (command) {
                case FORWARD:
                    if (!moveForward()) {
                        return format("Obstacle found at the %s of %s", direction, position);
                    }
                    break;

                case BACKWARD:
                    if (!moveBackward()) {
                        return format("Obstacle found at the %s of %s", direction, position);
                    }
                    break;

                case LEFT:
                    turnLeft();
                    break;

                case RIGHT:
                    turnRight();
                    break;

                case null, default:
                    throw new IllegalArgumentException(format("Invalid command %s", c));
            }
        }
        return format("Position: %s, Direction: %s", position, direction);
    }

    private boolean moveForward() {
        final Position newPosition = position.forward(direction);
        return moveTo(wrapPosition(newPosition));
    }

    private boolean moveBackward() {
        final Position newPosition = position.behind(direction);
        return moveTo(wrapPosition(newPosition));
    }

    private boolean moveTo(final Position position) {
        if (surface.obstacles().contains(position)) {
            return false;
        }

        this.position = position;
        return true;
    }

    private void turnRight() {
        final Direction[] directions = Direction.values();
        direction = directions[(direction.ordinal() + 1) % directions.length];
    }

    private void turnLeft() {
        final Direction[] directions = Direction.values();
        direction = directions[(direction.ordinal() + 3) % directions.length];
    }

    private Position wrapPosition(final Position position) {
        final int wrappedX = (position.x() + surface.height()) % surface.height();
        final int wrappedY = (position.y() + surface.width()) % surface.width();

        return new Position(wrappedX, wrappedY);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
