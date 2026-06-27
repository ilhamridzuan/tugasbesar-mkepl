package com.mycompany.recipeease;

import com.mycompany.recipeease.managers.Favorite;
import com.mycompany.recipeease.managers.Video;
import com.mycompany.recipeease.managers.Community;
import com.mycompany.recipeease.utils.InvalidRatingException;
import com.mycompany.recipeease.models.User;
import com.mycompany.recipeease.models.Rating;
import com.mycompany.recipeease.models.Recipe;

import java.util.*;

public class RecipeTest {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Recipe> recipeList = new ArrayList<>();
    private static Community community = new Community();
    private static List<User> userList = new ArrayList<>();
    private static User loggedInUser = null;
    private static List<Video> videoList = new ArrayList<>();
    private static List<Favorite> favoriteList = new ArrayList<>();

    public static void main(String[] args) throws InvalidRatingException {
        // Create default admin and users
        userList.add(new Administrator(1, "admin", "admin123", "admin@recipeease.com", "administrator"));
        userList.add(new User(2, "user1", "password1", "user1@example.com", "user"));

        createDummyData();
        int choice = 0;
        do {
            try {
                System.out.println("\n=== RecipeEase Menu ===");
            if (loggedInUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> login();
                    case 2 -> register();
                    case 3 -> System.out.println("Exiting RecipeEase. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } else {
                
                System.out.println("1. Add Recipe");
                System.out.println("2. View Recipes");
                System.out.println("3. Add Comment to Recipe");
                System.out.println("4. Rate Recipe");
                System.out.println("5. View Comments");
                System.out.println("6. View Average Ratings by Recipe");
                System.out.println("7. Add Video Tutorial");
                System.out.println("8. View Video Tutorial");
                System.out.println("9. Add Recipe to Favorites");
                System.out.println("10. View Favorite Recipes");
                System.out.println("11. View All Recipe Details");
                System.out.println("12. Search Recipe");
                System.out.println("13. Logout");
                System.out.println("14. Administrator Options");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addRecipe();
                    case 2 -> viewRecipes();
                    case 3 -> addComment();
                    case 4 -> rateRecipe();
                    case 5 -> viewComments();
                    case 6 -> viewAverageRatings();
                    case 7 -> addVideoTutorial();
                    case 8 -> viewVideoTutorials();
                    case 9 -> addToFavorites();
                    case 10 -> viewFavorites();
                    case 11 -> viewAllRecipeDetails();
                    case 12 -> searchRecipe();
                    case 13 -> logout();
                    case 14 -> {
                        if (loggedInUser instanceof Administrator) {
                            adminOptions();
                        } else {
                            System.out.println("Access denied. Administrator only.");
                        }
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
             } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (choice != 3 || loggedInUser != null);
    }
    
   //untuk login ke dalam aplikasi
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful! Welcome, " + username);
                return;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
    }
    
    //untuk mendaftarkan pengguna baru.
    private static void register() {
        System.out.println("\n--- Register ---");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }
        int newUserID = userList.size() + 1;
        User newUser = new User(newUserID, username, password, email, "user");
        userList.add(newUser);
        System.out.println("Registration successful! You can now log in.");
    }
    
    //untuk logout pengguna saat ini.
    private static void logout() {
        System.out.println("Logging out " + loggedInUser.getUsername() + ". Goodbye!");
        loggedInUser = null;
    }
    
    //Menu khusus untuk admin
    private static void adminOptions() {
        int adminChoice;
        Administrator admin = (Administrator) loggedInUser;
        do {
            System.out.println("\n--- Administrator Options ---");
            System.out.println("1. Manage Comments");
            System.out.println("2. Manage Users");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1 -> manageComments(admin);
                case 2 -> manageUsers(admin);
                case 3 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (adminChoice != 3);
    }
    
    //untuk mengelola komentar oleh admin
    private static void manageComments(Administrator admin) {
    System.out.println("\n--- Manage Comments ---");
    System.out.println("1. View Comments");
    System.out.println("2. Add Comment");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (choice) {
        case 1 -> {
            List<Comment> comments = community.getComments();
            if (comments.isEmpty()) {
                System.out.println("No comments available.");
            } else {
                for (Comment comment : comments) {
                    System.out.println("ID: " + comment.getCommentID() +
                            ", Author: " + comment.getAuthor() +
                            ", Content: " + comment.getContent());
                }
            }
        }
        case 2 -> {
            System.out.print("Enter Comment Content: ");
            String content = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            Comment newComment = new Comment(community.getComments().size() + 1, content, author, new Date());
            community.addComment(newComment);
            System.out.println("Comment added successfully.");
        }
    }
}

    
    //untuk mengelola pengguna oleh admin
    private static void manageUsers(Administrator admin) {
        System.out.println("\n--- Manage Users ---");
    System.out.println("1. View All Users");
    System.out.println("2. Add User");
    System.out.println("3. Block User");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
        case 1 -> {
            if (userList.isEmpty()) {
                System.out.println("No users available.");
            } else {
                for (User user : userList) {
                    System.out.println("ID: " + user.getUserID() + " | Username: " + user.getUsername() + " | Role: " + user.getRole());
                }
            }
        }
        case 2 -> {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            User newUser = new User(userList.size() + 1, username, password, email, "user");
            userList.add(newUser);
            System.out.println("User added successfully.");
        }
        case 3 -> {
            System.out.print("Enter Username to Block: ");
            String username = scanner.nextLine();
            boolean removed = userList.removeIf(user -> user.getUsername().equals(username));
            if (removed) {
                System.out.println("User blocked successfully.");
            } else {
                System.out.println("User not found.");
            }
        }
        default -> System.out.println("Invalid choice. Please try again.");
    }
}
    
    //untuk menambahkan resep baru.
    private static void addRecipe() {
        System.out.println("\n--- Add a Recipe ---");
        System.out.print("Enter Recipe Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter Instructions: ");
        String instructions = scanner.nextLine();

        Recipe recipe = new Recipe(recipeList.size() + 1, title, ingredients, instructions);
        recipeList.add(recipe);
        System.out.println("Recipe added successfully!");
    }
    
    //untuk melihat daftar semua resep
    private static void viewRecipes() {
        System.out.println("\n--- Recipe List ---");
        if (recipeList.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (Recipe recipe : recipeList) {
                System.out.println(recipe);
            }
        }
    }
    
    //untuk menambahkan komentar pada resep tertentu
    private static void addComment() {
        System.out.println("\n--- Add a Comment ---");
        System.out.print("Enter Recipe ID: ");
        int recipeID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Recipe recipe = findRecipeByID(recipeID);
        if (recipe != null) {
            System.out.print("Enter Comment Author: ");
            String author = scanner.nextLine();
            System.out.print("Enter Comment Content: ");
            String content = scanner.nextLine();

            Comment comment = new Comment(community.getComments().size() + 1, content, author, new Date());
            community.addComment(comment);
            System.out.println("Comment added successfully to recipe: " + recipe.getTitle());
        } else {
            System.out.println("Recipe not found!");
        }
    }
    
    //untuk memberikan rating pada resep tertentu
    private static void rateRecipe() throws InvalidRatingException {
        System.out.println("\n--- Rate a Recipe ---");
        System.out.print("Enter Recipe ID: ");
        int recipeID = scanner.nextInt();
        scanner.nextLine();
        Recipe recipe = findRecipeByID(recipeID);

        if (recipe != null) {
            float score = -1;
            while (score < 0.0 || score > 5.0) {
                System.out.print("Enter Rating (0.0 - 5.0): ");
                if (scanner.hasNextFloat()) {
                    score = scanner.nextFloat();
                    if (score < 0.0 || score > 5.0) {
                        System.out.println("Invalid rating. Please enter a score between 0.0 and 5.0.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric rating.");
                    scanner.next();
                }
            }
            Rating rating = new Rating(community.getRatings().size() + 1, score, "Anonymous", recipe.getTitle());
            community.addRating(rating);
            System.out.println("Rating added successfully!");

        } else {
            System.out.println("Recipe not found!");
        }
    }
    
    //untuk melihat komentar pada resep
    private static void viewComments() {
        System.out.println("\n--- View Comments ---");
        List<Comment> comments = community.getComments();
        if (comments.isEmpty()) {
            System.out.println("No comments available.");
        } else {
            for (Comment comment : comments) {
                System.out.println("Author: " + comment.getAuthor() + ", Comment: " + comment.getContent());
            }
        }
    }
    
    //untuk menampilkan rata-rata rating tiap resep
    private static void viewAverageRatings() {
        System.out.println("\n--- Average Ratings by Recipe ---");
        Map<String, Float> averageRatings = community.getAverageRatingByRecipe();
        if (averageRatings.isEmpty()) {
            System.out.println("No ratings available.");
        } else {
            averageRatings.forEach((recipeTitle, avgRating) -> 
                System.out.println("Recipe: " + recipeTitle + ", Average Rating: " + avgRating));
        }
    }
    
    //untuk menambahkan tutorial video pada resep
    private static void addVideoTutorial() {
    System.out.println("\n--- Add Video Tutorial ---");
    System.out.print("Enter Recipe ID: ");
    int recipeID = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    Recipe recipe = findRecipeByID(recipeID);

        if (recipe != null) {
            System.out.print("Enter Video Link: ");
            String videoLink = scanner.nextLine();
            int videoID = videoList.size() + 1;

            Video video = new Video(videoID, videoLink, recipeID);
            videoList.add(video);
            System.out.println("Video tutorial added successfully for recipe: " + recipe.getTitle());
        } else {
            System.out.println("Recipe not found!");
        }
    }
    
    //untuk melihat tutorial video pada resep tertentu
    private static void viewVideoTutorials() {
    System.out.println("\n--- View Video Tutorials ---");
    System.out.print("Enter Recipe ID: ");
    int recipeID = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    Recipe recipe = findRecipeByID(recipeID);

        if (recipe != null) {
            System.out.println("Video tutorials for recipe: " + recipe.getTitle());
            boolean found = false;
            for (Video video : videoList) {
                if (video.getRecipeID() == recipeID) {
                    System.out.println(video);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No video tutorials available for this recipe.");
            }
        } else {
            System.out.println("Recipe not found!");
        }
    }
    
    //untuk menambahkan resep ke dalam daftar favorit pengguna
    private static void addToFavorites() {
    if (loggedInUser == null) {
        System.out.println("You need to log in to add recipes to favorites.");
        return;
    }

    System.out.print("Enter Recipe ID to add to favorites: ");
    int recipeID = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    Recipe recipe = findRecipeByID(recipeID);

        if (recipe != null) {
            Favorite favorite = findOrCreateFavorite(loggedInUser);
            favorite.addFavoriteRecipe(recipe);
        } else {
            System.out.println("Recipe not found!");
        }
    }
    
    private static void viewFavorites() {
    if (loggedInUser == null) {
        System.out.println("You need to log in to view your favorites.");
        return;
    }

        Favorite favorite = findOrCreateFavorite(loggedInUser);
        favorite.viewFavoriteRecipes();
    }
    
    private static Favorite findOrCreateFavorite(User user) {
    for (Favorite favorite : favoriteList) {
        if (favorite.getUser().equals(user)) {
            return favorite;
        }
    }
        Favorite newFavorite = new Favorite(user);
        favoriteList.add(newFavorite);
        return newFavorite;
    }
    
   private static void viewAllRecipeDetails() {
    System.out.println("\n--- View All Recipe Details ---");
    if (recipeList.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (Recipe recipe : recipeList) {
                System.out.println(recipe);
            }
        }

    for (Recipe recipe : recipeList) {
//        System.out.println("Recipe ID: " + recipe.getRecipeID());
//        System.out.println("Title: " + recipe.getTitle());
//        System.out.println("Ingredients: " + recipe.getIngredients());
//        System.out.println("Instructions: " + recipe.getInstructions());

        // Display comments
        System.out.println("Comments:");
        boolean hasComments = false;
        for (Comment comment : community.getComments()) {
            if (comment.getRecipeID() == recipe.getRecipeID()) {
                System.out.println("- " + comment.getContent() + " (by " + comment.getAuthor() + ")");
                hasComments = true;
            }
        }
        if (!hasComments) {
            System.out.println("No comments available.");
        }

        // Display video tutorials
        System.out.println("Video Tutorials:");
        boolean hasVideos = false;
        for (Video video : videoList) {
            if (video.getRecipeID() == recipe.getRecipeID()) {
                System.out.println("- " + video.getVideoLink());
                hasVideos = true;
            }
        }
        if (!hasVideos) {
            System.out.println("No video tutorials available.");
        }

        // Display ratings
        System.out.println("Ratings:");
        float averageRating = community.calculateAverageRatingForRecipe(recipe.getTitle());
            if (averageRating > 0) {
                System.out.println("- Average Rating: " + averageRating);
            } else {
                System.out.println("No ratings available.");
            }

            System.out.println("-----------------------------");
        }
    }

    private static void searchRecipe() {
    System.out.println("\n--- Search Recipe ---");
    System.out.print("Enter keyword to search for recipe title: ");
    String keyword = scanner.nextLine().toLowerCase();

    List<Recipe> searchResults = new ArrayList<>();
    for (Recipe recipe : recipeList) {
        if (recipe.getTitle().toLowerCase().contains(keyword)) {
            searchResults.add(recipe);
        }
    }

        if (searchResults.isEmpty()) {
            System.out.println("No recipes found with the keyword: " + keyword);
        } else {
            System.out.println("Recipes found:");
            for (Recipe recipe : searchResults) {
                System.out.println("Recipe ID: " + recipe.getRecipeID());
                System.out.println("Title: " + recipe.getTitle());
                System.out.println("-----------------------------");
            }
        }
    }
    
    //untuk mencari resep berdasarkan ID.
    private static Recipe findRecipeByID(int recipeID) {
        for (Recipe recipe : recipeList) {
            if (recipe.getRecipeID() == recipeID) {
                return recipe;
            }
        }
        return null;
    }
    
    private static void createDummyData() {
    // Add dummy recipes
    recipeList.add(new Recipe(1, "Spaghetti Carbonara", "Spaghetti, Eggs, Parmesan, Pancetta", "Cook spaghetti, mix with sauce."));
    recipeList.add(new Recipe(2, "Chicken Curry", "Chicken, Curry Powder, Coconut Milk", "Cook chicken with curry powder and coconut milk."));

    // Add dummy comments
    community.addComment(new Comment(1, "Delicious recipe!", "user1", new Date()));
    community.addComment(new Comment(2, "Easy to follow!", "admin", new Date()));

    // Add dummy ratings
    try {
        community.addRating(new Rating(1, 4.5f, "user1", "Spaghetti Carbonara"));
        community.addRating(new Rating(2, 5.0f, "admin", "Chicken Curry"));
    } catch (InvalidRatingException e) {
        System.out.println("Error adding dummy rating: " + e.getMessage());
    }

    // Add dummy videos
    videoList.add(new Video(1, "https://youtu.be/spaghetti_tutorial", 1));
    videoList.add(new Video(2, "https://youtu.be/chicken_curry_tutorial", 2));

    System.out.println("Dummy data created successfully.");
}

}
