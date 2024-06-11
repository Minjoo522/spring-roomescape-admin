package roomescape.controller.api;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roomescape.dto.ReservationRequest;
import roomescape.dto.ReservationResponse;
import roomescape.dto.ReservationResponses;
import roomescape.service.ReservationService;

@RestController
public class AdminReservationController {
    private final ReservationService reservationService;

    public AdminReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/admin/reservations")
    public ResponseEntity<ReservationResponses> getReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping("/admin/reservations")
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody ReservationRequest request) {
        ReservationResponse response = reservationService.save(request);
        return ResponseEntity.created(URI.create("/reservations/" + response.id())).body(response);
    }

    @DeleteMapping("/admin/reservations/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {
        reservationService.delete(reservationId);
        return ResponseEntity.noContent().build();
    }
}
