package service;

import exception.*;
import model.Medicine;
import repository.Repository;

public class PharmacyValidationService {

    public void validateMedicineNotExpired(Medicine medicine) {
        if (medicine.isExpired()) {
            throw new ExpiredMedicineException("Препарат просрочен");
        }
    }

    public void validateMedicineExists(Repository<Medicine, String> repo, String id) {
        if (repo.findById(id) == null) {
            throw new MedicineNotFoundException("Лекарство не найдено");
        }
    }

    public void validatePrescription(Medicine medicine, boolean hasPrescription) {
        if (medicine.isPrescriptionRequired() && !hasPrescription) {
            throw new PrescriptionRequiredException("Нужен рецепт");
        }
    }

    public void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new InvalidInputException("Количество должно быть больше 0");
        }
    }
}