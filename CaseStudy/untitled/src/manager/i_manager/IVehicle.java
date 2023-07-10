package manager.i_manager;

import model.Rental;

public interface IVehicle<E> {
    Rental rentVehicle();
    Rental returnVehicle();
}
