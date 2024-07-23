import java.util.*;
class Dish {
    private int num;
    private String name;
    private String description;
    private double price;
    private boolean isVegetarian;

    public Dish(int num,String name, String description, double price, boolean isVegetarian) {
        this.num=num;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }
    public int getnum() {
        return num;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public String toString() {
        return "{num="+ num +" \tname=" + name + ",\tdescription=" + description + ", \tprice=" + price + ",\t isVegetarian=" + isVegetarian + '}';
    }
}


//Checkout
class OrderProcessor {
    public static double computeTotalOrderValue(List<Dish> order) {
        double total = 0.0;
        for (Dish dish : order) {
            total += dish.getPrice();
        }
        return total;
    }
}

//Filtering
class DishFilter {
    //Filteri Dishes by category
    public static List<Dish> filterVegetarianDishes(List<Dish> dishes) {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            }
        }
        return vegetarianDishes;
    }
    //Filtering dishes by price
    public static List<Dish> filterDishesBelowPrice(List<Dish> dishes, double price) {
        List<Dish> cost = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getPrice() < price) {
                cost.add(dish);
            }
        }
        return cost;
    }
}

public class DishesTask {
    public static void addToCart(Dish margherita,Dish caprese, Dish pepperoni, Dish item_4, Dish item_5, Dish item_6){
        Scanner scn=new Scanner(System.in);
        boolean addItem=true;
            List<Dish> dishes = new ArrayList<>();
            while(addItem) {
                //Displaying all the items(Menu Card)
            System.out.println(margherita.toString());
            System.out.println(caprese.toString());
            System.out.println(pepperoni.toString());
            System.out.println(item_4.toString());
            System.out.println(item_5.toString());
            System.out.println(item_6.toString());
            System.out.println("Enter the number of the dish you want to add to the cart: ");
            System.out.println("Select Item from 1 to 6");
            System.out.println("Select 7 to Check Out");
            int item=scn.nextInt();
            //Adding items to cart
            switch (item) {
                case 1:
                    dishes.add(margherita);
                    break;

                case 2:
                    dishes.add(caprese);
                    break;
                case 3:
                    dishes.add(pepperoni);
                    break;
                case 4:
                    dishes.add(item_4);
                    break;
                case 5:
                    dishes.add( item_5);
                    break;
                case 6:
                    dishes.add(item_6);
                    break;
                case 7:
                //Checkout
                    addItem=false;
                    double totalOrderValue = OrderProcessor.computeTotalOrderValue(dishes);
                    System.out.println("Total Order Value: " + totalOrderValue);
                default:
                System.out.println("Invalid Input");
                break;
            }
            }
            scn.close();
    }
    public static void main(String[] args) {
        //Dishes creation
        Dish margherita = new Dish(1, "Margherita", "Classic cheese pizza", 10.99, false);
        Dish caprese = new Dish(2, "Caprese Salad", "Fresh mozzarella, tomatoes, and basil", 7.99, true);
        Dish pepperoni = new Dish(3, "Pepperoni Pizza", "Pizza with pepperoni slices", 12.99, false);
        Dish item_4 = new Dish(4, "Spaghetti Carbonara", "Pasta with eggs,and pepper", 14.99, false);
        Dish item_5 = new Dish(5, "item_5", "Coffee-flavored Italian dessert", 6.99, true);
        Dish item_6 = new Dish(6, "item_6", "Grilled bread with tomatoes, and garlic", 5.99, true);
        boolean next=true;
        List<Dish> order = Arrays.asList(margherita, caprese, pepperoni, item_4, item_5, item_6);
        Scanner sc=new Scanner(System.in);
        while(next) {
        System.out.println("1.Select items\n2.Filter by Category\n3.Filter by cost\n4.Exit");
        int input=sc.nextInt();
        switch (input) {
            case 1:
                addToCart(margherita, caprese, pepperoni, item_4, item_5, item_6);
                break;
            case 2:
                //Calling Filtering by category
                List<Dish> vegetarianDishes = DishFilter.filterVegetarianDishes(order);
                System.out.println("Vegetarian Dishes: " + vegetarianDishes);
                break;
            case 3:
            //Calling Filtering by Price
                System.out.println("Enter Cost under which you want the Dishes:");
                int ct=sc.nextInt();
                List<Dish> cost = DishFilter.filterDishesBelowPrice(order, ct);
                System.out.println("Affordable Dishes under $"+ct+".00: " + cost);
                break;
            case 4:
                next=false;
                break;
            default:
                break;
        }    
    }
    sc.close();
}

}
