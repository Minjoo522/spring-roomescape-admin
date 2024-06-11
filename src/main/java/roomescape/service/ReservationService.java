package roomescape.service;

import org.springframework.stereotype.Service;
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
}
