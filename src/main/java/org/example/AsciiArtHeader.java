package org.example;

public class AsciiArtHeader {

    public static void printAsciiArtHeader() {

        String[] headerLines = {
                "            ___     ___    _   _     ___     ___    ___              ___                               ___    _  _     ___     _       _                ___     ___     ___    _____  ",
                "    o O O  / __|   | _ \\  | | | |   | _ \\   | _ \\  | __|     o O O  /   \\     o O O   ___      o O O  / __|  | || |   | __|   | |     | |       o O O  / __|   / _ \\   | _ \\  |_   _| ",
                "   o      | (_ |   |   /  | |_| |   |  _/   |  _/  | _|     o       | - |    o       |___|    o       \\__ \\  | __ |   | _|    | |__   | |__    o       \\__ \\  | (_) |  |   /    | |   ",
                "  TS__[O]  \\___|   |_|_\\   \\___/   _|_|_   _|_|_   |___|   TS__[O]  |_|_|   TS__[O]  _____   TS__[O]  |___/  |_||_|   |___|   |____|  |____|  TS__[O]  |___/   \\___/   |_|_\\   _|_|_  ",
                " {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\" |_| \"\"\" |_|\"\"\"\"\"| {======|_|\"\"\"\"\"| {======|_|     | {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| {======|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| ",
                "./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'./o--000'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'./o--000'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'"
        };

        String horizontalBorder = "═";
        String verticalBorder = "║";
        String cornerTopLeft = "╔";
        String cornerTopRight = "╗";
        String cornerBottomLeft = "╚";
        String cornerBottomRight = "╝";

        int maxWidth = 0;
        for (String line : headerLines) {
            maxWidth = Math.max(maxWidth, line.length());
        }

        String topBorder = cornerTopLeft + new String(new char[maxWidth + 2]).replace("\0", horizontalBorder) + cornerTopRight;
        String bottomBorder = cornerBottomLeft + new String(new char[maxWidth + 2]).replace("\0", horizontalBorder) + cornerBottomRight;

        System.out.println(topBorder);
        for (String line : headerLines) {
            while (line.length() < maxWidth) {
                line += " ";
            }

            System.out.println(verticalBorder + " " + line + " " + verticalBorder);
        }

        System.out.println(bottomBorder);
    }

    public static void main(String[] args) {
        printAsciiArtHeader();
    }
}


