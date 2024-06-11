package roomescape.service;

import org.springframework.stereotype.Service;
import roomescape.domain.Reservation;
import roomescape.dto.ReservationRequest;
import roomescape.dto.ReservationResponse;
import roomescape.dto.ReservationResponses;
import roomescape.repository.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponses findAll() {
        return ReservationResponses.from(reservationRepository.findAll());
    }

    public ReservationResponse save(ReservationRequest request) {
        Reservation newReservation = reservationRepository.save(request.toReservation());
        return ReservationResponse.from(newReservation);
    }
}
