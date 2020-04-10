import static view.InputView.*;
import static view.OutputView.*;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		printMainMenus();
		while (inputMainMenuNumber() != 3) {
			List<Table> tables = TableRepository.tables();
			printTables(tables);

			final int tableNumber = inputTableNumber();

			final List<Menu> menus = MenuRepository.menus();
			printMenus(menus);
			final int menuNumber = inputFoodMenuNumber();
			final int menuCount = inputMenuCount();

			Table table = TableRepository.findTable(tableNumber);
			table.addMenu(MenuRepository.getMenu(menuNumber), menuCount);
			printOrders(table.getOrders());
		}
	}
}
