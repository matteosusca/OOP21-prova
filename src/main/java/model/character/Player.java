package model.character;

import model.character.tools.health.Health;
import util.Vector2D;

/**
 * The player is the main character of a game, it can means that can respawn if
 * it dies, has a lives counter to manage the respawn logic and can hold items
 * (such as power ups and weapons) in its inventory.
 */
public final class Player extends Character {

    /**
     * Delineates the conditions which limit the entity's crouching capabilities.
     */
    public enum Crouch {
        /** Crouch could be everything. */
        FREE,
        /** Crouch has to be false. */
        UP,
        /** Crouch has to be true. */
        DOWN;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!DA RIGUARDARE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * The coefficient that has to be applied when the player is on a slippery floor.
     */
    public static final double SLIPPERYCONSTANT = 1;
    /**
     * The coefficient that has to be applied when the player is on an adherent floor.
     */
    public static final double FRICTIONCONSTANT = 0.1;
    /**
     * The coefficient that has to be applied when the player is heavier.
     */
    public static final double FATTYCONSTANT = 1;
    /**
     * The coefficient that has to be applied when the player is lighter.
     */
    public static final double LIGHTYCONSTANT = 0.1;
    /**
     * The coefficient that has to be applied when the player is faster.
     */
    public static final double MAXSPEEDREACHABLE = 1;
    /**
     * Delineates the conditions which limit the entity's crouching capabilities.
     */
    private Crouch crouchCondition = Crouch.FREE;
    /**
     * Represent the entity intention to crouch.
     */
    private boolean crouchKey;
    /**
     * The current remaining player lives.
     */
    private int lives;
    // private final List<Item> items;

    private Player(final PlayerBuilder builder) {
        super(builder.position, builder.hitbox, builder.health/* , builder.weapon */);
        this.lives = builder.lives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveEntity() {
        super.moveEntity();
        if (this.crouchCondition == Crouch.FREE) {
            super.setCrouch(crouchKey);
        } else if (this.crouchCondition == Crouch.DOWN) {
            super.setCrouch(true);
        } else {
            super.setCrouch(false);
        }
    }

    /**
     * Sets the crouch condition.
     * 
     * @param crouchCond
     */
    public void setCrouchCondition(final Crouch crouchCond) {
        this.crouchCondition = crouchCond;
    }

    /**
     * Gets the crouch condition.
     * 
     * @return the crouch condition
     */
    public Crouch getCrouchCondition() {
        return this.crouchCondition;
    }

    /**
     * Sets the crouch key.
     * 
     * @param crouchKey
     */
    public void setCrouchKey(final boolean crouchKey) {
        this.crouchKey = crouchKey;
    }

    /**
     * Return if the crouch key is pressed.
     * 
     * @return crouch key
     */
    public boolean getCrouchKey() {
        return this.crouchKey;
    }
    /**
     * Gets the remaining lives.
     * 
     * @return lives
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Sets the player position only if it has at least one remaining life.
     * 
     * @param position
     * 
     * @throws IllegalStateException if there aren't remaining lives.
     */
    public void respawn(final Vector2D position) {
        this.lives--;
        if (this.lives >= 0) {
            super.setPosition(position);
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Picks up the item only if it's close enough to take it
     * 
     * @param item
     */
    /*
     * public void interact(final Item item) { if(super.isColliding(item)) {
     * this.items.add(item); } }
     */

    @Override
    public String toString() {
        return super.toString() + " " + this.lives;
    }

    /**
     * The player builder. At the end of the build all fields must be instantiated.
     */
    public static class PlayerBuilder {
        private Vector2D hitbox;
        private Vector2D position;
        private Health health;
        private int lives;

        // private Weapon weapon;
        /**
         * The method that sets the player hitbox.
         * 
         * @param hitbox
         * @return this player builder
         */
        public PlayerBuilder hitbox(final Vector2D hitbox) {
            this.hitbox = hitbox;
            return this;
        }

        /**
         * The method that sets the player position.
         * 
         * @param position
         * @return this player builder
         */
        public PlayerBuilder position(final Vector2D position) {
            this.position = position;
            return this;
        }

        /**
         * The method that sets the player health.
         * 
         * @param health
         * @return this player builder
         */
        public PlayerBuilder health(final Health health) {
            this.health = health;
            return this;
        }

        /**
         * The method that sets the player lives.
         * 
         * @param lives
         * @return this player builder
         */
        public PlayerBuilder lives(final int lives) {
            this.lives = lives;
            return this;
        }

        /**
         * The method that sets the player weapon.
         * 
         * @param weapon
         */
        /*
         * public PlayerBuilder weapon(final Weapon weapon) { this.weapon = weapon;
         * return this;
         */
        /**
         * The method that builds the player with the set up values.
         * 
         * @return the built player
         * @throws IllegalStateException if at least one of the fields is null or if the lives are a
         * negative number.
         */
        public Player build() {
            this.consistencyCheck();
            return new Player(this);
        }

        private void consistencyCheck() {
            /*
             * if (this.lives < 0 || this.health == null || this.hitbox == null ||
             * this.position == null //|| this.weapon == null ) { throw new
             * IllegalStateException(); }
             */
        }
    }
}
