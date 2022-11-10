package Menu;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ModelMenuItem {

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

    public ModelMenuItem(Icon icon, String menuName, String[] subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    public ModelMenuItem() {
    }
    private Icon icon;
    private String menuName;
    private String subMenu[];

}
