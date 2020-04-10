import static view.InputView.*;
import static view.OutputView.*;

import java.util.Map;

import domain.MainMenu;
import domain.Menu;
import domain.MenuRepository;
import domain.Payment;
import domain.PaymentManager;
import domain.Table;
import domain.TableRepository;
import view.dto.OrdersDto;
import view.dto.TablesDto;

public class Application {
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
		TablesDto tablesDto = new TablesDto(TableRepository.tables());
		printTables(tablesDto);
		Table table = TableRepository.findTable(inputTableNumber());

		printMenus(MenuRepository.menus());
		table.addMenu(MenuRepository.getMenu(inputFoodMenuNumber()), inputMenuCount());
	}

	private static void pay() {
		TablesDto tablesDto = new TablesDto(TableRepository.tables());
		printTables(tablesDto);
		Table table = TableRepository.findTable(inputTableNumber());
		Map<Menu, Integer> orders = table.getOrders();
		printOrders(new OrdersDto(orders));

		Payment paymentType = Payment.of(inputPaymentNumber(table.getNumber()));
		PaymentManager paymentManager = new PaymentManager(paymentType, table.getBills());
		printBills(paymentManager.calculate());
		table.deleteAllOrders();
	}
}
