import static view.InputView.*;
import static view.OutputView.*;

import java.util.List;

import domain.MainMenu;
import domain.Menu;
import domain.MenuRepository;
import domain.Payment;
import domain.PaymentManager;
import domain.Table;
import domain.TableRepository;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		MainMenu mainMenuNumber;

		do {
			printMainMenus();
			mainMenuNumber = MainMenu.of(inputMainMenuNumber());
			orderOrPay(mainMenuNumber);
		} while (mainMenuNumber.isNotEnd());
	}

	private static void orderOrPay(MainMenu mainMenuNumber) {
		if (mainMenuNumber.isOrder()) {
			order();
		}
		if (mainMenuNumber.isPay()) {
			pay();
		}
	}

	private static void order() {
		List<Table> tables = TableRepository.tables();
		printTables(tables);

		final int tableNumber = inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		printMenus(menus);
		final int menuNumber = inputFoodMenuNumber();
		final int menuCount = inputMenuCount();

		Table table = TableRepository.findTable(tableNumber);
		table.addMenu(MenuRepository.getMenu(menuNumber), menuCount);

	}

	private static void pay() {
		List<Table> tables = TableRepository.tables();
		printTables(tables);
		final int tableNumber = inputTableNumber();
		Table table = TableRepository.findTable(tableNumber);
		printOrders(table.getOrders());
		Payment paymentType = Payment.of(inputPaymentNumber(tableNumber));
		PaymentManager paymentManager = new PaymentManager(paymentType, table.getBills());
		printBills(paymentManager.calculate());
	}
}
