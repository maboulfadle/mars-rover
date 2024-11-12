package com.training;

/**
 * The {@link Position} class contains the rover position related operations.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
public record Position(int x, int y) {

    /**
     * Gets forward position.
     *
     * @param direction the direction
     * @return the forward position
     */
    public Position getForwardPosition(final Direction direction) {
        return getPosition(direction, 1);
    }

    /**
     * Gets backward position.
     *
     * @param direction the direction
     * @return the backward position
     */
    public Position getBackwardPosition(final Direction direction) {
        return getPosition(direction, -1);
    }

    private Position getPosition(final Direction direction, final int numberOfSteps) {
        int dx = 0, dy = 0;
        switch (direction) {
            case NORTH :
                dy = numberOfSteps;
                break;

            case SOUTH :
                dy = -numberOfSteps;
                break;

            case EAST :
                dx = numberOfSteps;
                break;

            case WEST :
                dx = -numberOfSteps;
                break;
        }
        return new Position(x + dx, y + dy);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        return object instanceof Position position && x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
