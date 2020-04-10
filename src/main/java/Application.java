import static view.InputView.*;
import static view.OutputView.*;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		printMainMenus();
		while (inputMainMenuNumber() != 3) {
			final List<Table> tables = TableRepository.tables();
			printTables(tables);

			final int tableNumber = inputTableNumber();

			final List<Menu> menus = MenuRepository.menus();
			printMenus(menus);
		}
	}
}
