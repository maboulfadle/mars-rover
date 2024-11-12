package com.training;

/**
 * The {@link Command} enum contains the commands that the rover needs to execute.
 *
 * @author mohammed aboulfadle
 * @since 11.2024
 */
public enum Command {

    FORWARD('f'),  // move forward
    BACKWARD('b'), // move backward
    LEFT('l'),     // turn left
    RIGHT('r');    // turn right

    private final Character symbol;

    Command(final Character symbol) {
        this.symbol = symbol;
    }

    /**
     * Instantiate a command based on the given {@code symbol}.
     *
     * @param symbol the symbol
     * @return the command
     */
    public static Command fromSymbol(final Character symbol) {
        for (final Command command : Command.values()) {
            if (command.symbol.equals(symbol)) {
                return command;
            }
        }
        return null;
    }
}
