package com.mycompany.recipeease.models;

import com.mycompany.recipeease.Administrator;
import com.mycompany.recipeease.RecipeHunter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for User, Administrator, and RecipeHunter classes.
 */
@DisplayName("User Model Tests")
class UserModelTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, "testuser", "password123", "test@email.com", "user");
    }

    // === Constructor & Getter Tests ===

    @Test
    @DisplayName("Constructor should set user ID correctly")
    void constructorShouldSetUserID() {
        assertEquals(1, user.getUserID());
    }

    @Test
    @DisplayName("Constructor should set username correctly")
    void constructorShouldSetUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    @DisplayName("Constructor should set password correctly")
    void constructorShouldSetPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    @DisplayName("Constructor should set email correctly")
    void constructorShouldSetEmail() {
        assertEquals("test@email.com", user.getEmail());
    }

    @Test
    @DisplayName("Constructor should set role correctly")
    void constructorShouldSetRole() {
        assertEquals("user", user.getRole());
    }

    // === Setter Tests ===

    @Test
    @DisplayName("setUsername should update username")
    void setUsernameShouldUpdateUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    @DisplayName("setPassword should update password")
    void setPasswordShouldUpdatePassword() {
        user.setPassword("newpass456");
        assertEquals("newpass456", user.getPassword());
    }

    @Test
    @DisplayName("setEmail should update email")
    void setEmailShouldUpdateEmail() {
        user.setEmail("new@email.com");
        assertEquals("new@email.com", user.getEmail());
    }

    @Test
    @DisplayName("setRole should update role")
    void setRoleShouldUpdateRole() {
        user.setRole("admin");
        assertEquals("admin", user.getRole());
    }

    @Test
    @DisplayName("setUserID should update user ID")
    void setUserIDShouldUpdateUserID() {
        user.setUserID(42);
        assertEquals(42, user.getUserID());
    }

    // === Behavior Method Tests (print-only, verify no exception) ===

    @Test
    @DisplayName("register should not throw exception")
    void registerShouldNotThrowException() {
        assertDoesNotThrow(() -> user.register());
    }

    @Test
    @DisplayName("login should not throw exception")
    void loginShouldNotThrowException() {
        assertDoesNotThrow(() -> user.login());
    }

    @Test
    @DisplayName("viewRecipe should not throw exception")
    void viewRecipeShouldNotThrowException() {
        assertDoesNotThrow(() -> user.viewRecipe());
    }

    @Test
    @DisplayName("rateRecipe should not throw exception")
    void rateRecipeShouldNotThrowException() {
        assertDoesNotThrow(() -> user.rateRecipe());
    }

    @Test
    @DisplayName("addComment should not throw exception")
    void addCommentShouldNotThrowException() {
        assertDoesNotThrow(() -> user.addComment());
    }

    // === Administrator Tests ===

    @Nested
    @DisplayName("Administrator Tests")
    class AdministratorTest {

        private Administrator admin;

        @BeforeEach
        void setUp() {
            admin = new Administrator(1, "admin", "adminpass", "admin@email.com", "admin");
        }

        @Test
        @DisplayName("Administrator should be an instance of User")
        void administratorShouldBeInstanceOfUser() {
            assertInstanceOf(User.class, admin);
        }

        @Test
        @DisplayName("Administrator should inherit username from User")
        void administratorShouldInheritUsername() {
            assertEquals("admin", admin.getUsername());
        }

        @Test
        @DisplayName("manageComments 'tambah' should not throw")
        void manageCommentsTambahShouldNotThrow() {
            assertDoesNotThrow(() -> admin.manageComments("tambah", "Komentar baru"));
        }

        @Test
        @DisplayName("manageComments 'hapus' should not throw")
        void manageCommentsHapusShouldNotThrow() {
            admin.manageComments("tambah", "Komentar test");
            assertDoesNotThrow(() -> admin.manageComments("hapus", "Komentar test"));
        }

        @Test
        @DisplayName("manageComments 'lihat' should not throw")
        void manageCommentsLihatShouldNotThrow() {
            admin.manageComments("tambah", "Komentar1");
            assertDoesNotThrow(() -> admin.manageComments("lihat", ""));
        }

        @Test
        @DisplayName("manageUsers 'tambah' should not throw")
        void manageUsersTambahShouldNotThrow() {
            assertDoesNotThrow(() -> admin.manageUsers("tambah", "newuser"));
        }

        @Test
        @DisplayName("manageUsers 'blokir' should not throw")
        void manageUsersBlokirShouldNotThrow() {
            admin.manageUsers("tambah", "user1");
            assertDoesNotThrow(() -> admin.manageUsers("blokir", "user1"));
        }

        @Test
        @DisplayName("manageUsers 'lihat' should not throw")
        void manageUsersLihatShouldNotThrow() {
            assertDoesNotThrow(() -> admin.manageUsers("lihat", ""));
        }

        @Test
        @DisplayName("manageComments with invalid action should not throw")
        void manageCommentsInvalidActionShouldNotThrow() {
            assertDoesNotThrow(() -> admin.manageComments("invalid", "test"));
        }

        @Test
        @DisplayName("manageUsers with invalid action should not throw")
        void manageUsersInvalidActionShouldNotThrow() {
            assertDoesNotThrow(() -> admin.manageUsers("invalid", "test"));
        }
    }

    // === RecipeHunter Tests ===

    @Nested
    @DisplayName("RecipeHunter Tests")
    class RecipeHunterTest {

        private RecipeHunter hunter;

        @BeforeEach
        void setUp() {
            hunter = new RecipeHunter(2, "hunter", "pass", "hunter@email.com", "user", "Indonesian Food");
        }

        @Test
        @DisplayName("RecipeHunter should be an instance of User")
        void recipeHunterShouldBeInstanceOfUser() {
            assertInstanceOf(User.class, hunter);
        }

        @Test
        @DisplayName("RecipeHunter should inherit username from User")
        void recipeHunterShouldInheritUsername() {
            assertEquals("hunter", hunter.getUsername());
        }

        @Test
        @DisplayName("getSearchPreferences should return preferences")
        void getSearchPreferencesShouldReturnPreferences() {
            assertEquals("Indonesian Food", hunter.getSearchPreferences());
        }

        @Test
        @DisplayName("setSearchPreferences should update preferences")
        void setSearchPreferencesShouldUpdatePreferences() {
            hunter.setSearchPreferences("Western Food");
            assertEquals("Western Food", hunter.getSearchPreferences());
        }

        @Test
        @DisplayName("searchRecipe should not throw exception")
        void searchRecipeShouldNotThrowException() {
            assertDoesNotThrow(() -> hunter.searchRecipe());
        }

        @Test
        @DisplayName("saveRecipe should not throw exception")
        void saveRecipeShouldNotThrowException() {
            assertDoesNotThrow(() -> hunter.saveRecipe());
        }
    }
}
