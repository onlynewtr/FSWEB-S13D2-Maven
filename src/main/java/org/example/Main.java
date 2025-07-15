package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707)); // true
        System.out.println(isPalindrome(11212)); // false

        System.out.println(isPerfectNumber(6)); // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5)); // false
        System.out.println(isPerfectNumber(-1)); // false

        System.out.println(numberToWords(123)); // "One Two Three"
        System.out.println(numberToWords(1010)); // "One Zero One Zero"
        System.out.println(numberToWords(-12)); // "Invalid Value"
    }

    // Palindrom Sayıyı Bulma
    public static boolean isPalindrome(int number) {
        int original = Math.abs(number);
        int reversed = 0;
        int temp = original;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversed = reversed * 10 + lastDigit;
            temp /= 10;
        }

        return original == reversed;
    }

    // Mükemmel Sayıları Bulma
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıları Kelimelere Dökme
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        if (number == 0) {
            return "Zero";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        StringBuilder result = new StringBuilder();

        int reversedNumber = reverseNumber(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int digit = reversedNumber % 10;
            result.append(words[digit]).append(" ");
            reversedNumber /= 10;
        }

        // Eğer sayıda eksik sıfırlar varsa, onları da ekleyelim
        for (int i = 0; i < originalDigitCount - reversedDigitCount; i++) {
            result.append("Zero ");
        }

        return result.toString().trim();
    }

    // Sayıyı ters çevirme yardımcı metodu
    private static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    // Bir sayının kaç basamaklı olduğunu bulma yardımcı metodu
    private static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}