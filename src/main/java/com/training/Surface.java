package com.training;

import java.util.Set;

/**
 * The {@link Surface} class contains the surface where the rover dropped-in related operations.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
public record Surface(int height, int width, Set<Position> obstacles) {

    /**
     * Define obstacle.
     *
     * @param position the position
     */
    public void defineObstacle(final Position position) {
        obstacles.add(position);
    }
}
