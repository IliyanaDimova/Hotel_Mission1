package eu.deltasource.internship.hotel.domain;

/**
 * Extends runtime exception
 * It is thrown in Room if addCommodity() finds the commodity already belongs to a room
 */
public class CommodityAlreadyBelongsToRoomException extends RuntimeException {
    CommodityAlreadyBelongsToRoomException(String message) {
        super(message);
    }
}
