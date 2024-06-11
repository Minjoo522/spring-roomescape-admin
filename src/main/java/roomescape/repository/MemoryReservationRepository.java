package roomescape.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;

@Repository
public class MemoryReservationRepository implements ReservationRepository {
    private final AtomicLong id = new AtomicLong(1);
    private final List<Reservation> reservations = new ArrayList<Reservation>();

    public MemoryReservationRepository() {
        reservations.add(new Reservation(id.getAndIncrement(), "브라운", LocalDate.of(2024, 6, 11), LocalTime.of(11, 0)));
        reservations.add(new Reservation(id.getAndIncrement(), "리브", LocalDate.of(2024, 6, 12), LocalTime.of(12, 10)));
        reservations.add(new Reservation(id.getAndIncrement(), "포케", LocalDate.of(2024, 6, 13), LocalTime.of(14, 20)));
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }

    @Override
    public Reservation save(Reservation reservation) {
        Reservation newReservation =
                new Reservation(id.getAndIncrement(), reservation.getName(), reservation.getDate(), reservation.getTime());
        reservations.add(newReservation);
        return newReservation;
    }
}
