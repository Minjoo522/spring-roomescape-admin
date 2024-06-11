package roomescape.dto;

import java.util.List;
import roomescape.domain.Reservation;

public record ReservationResponses(List<ReservationResponse> reservations) {

    public static ReservationResponses from(List<Reservation> reservations) {
        List<ReservationResponse> reservationResponses = reservations.stream()
                .map(ReservationResponse::from)
                .toList();
        return new ReservationResponses(reservationResponses);
    }
}
