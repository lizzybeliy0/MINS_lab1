import model.Medicine;
import model.PrescriptionType;
import model.Sale;
import repository.MedicineRepository;
import repository.Repository;
import repository.SaleRepository;
import service.PharmacyService;
import service.PharmacyServiceInterface;
import ui.ConsoleUI;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Repository<Medicine, String> medicineRepo = new MedicineRepository();
        Repository<Sale, String> saleRepo = new SaleRepository();

        addTestData(medicineRepo);

        PharmacyServiceInterface service = new PharmacyService(medicineRepo, saleRepo);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }

    private static void addTestData(Repository<Medicine, String> repo) {
        repo.add(new Medicine("Парацетамол", PrescriptionType.WITHOUTPRESCRIPTION, LocalDate.now().plusDays(30), 50));
        repo.add(new Medicine("Амоксициллин", PrescriptionType.PRESCRIPTION, LocalDate.now().plusDays(20), 20));
        repo.add(new Medicine("Витаминки", PrescriptionType.WITHOUTPRESCRIPTION, LocalDate.now().minusDays(5), 10));
    }
}
// в репозитории init где тестовые данные - туда вынести
// интерфейс фармаси => его в консоль (у каждого сервиса свой интерфейс) (без этого зависит от конкретики, а не абстракции) - done