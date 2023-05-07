package com.project.iacontentfrontoffice.utils;

public class Utils {
    public static String createSlug(String input) {
        String slug = input.toLowerCase().trim();
        slug = slug.replaceAll("\\s+", "-"); // Replace spaces with hyphens
        slug = slug.replaceAll("[^a-z0-9-]", ""); // Remove non-alphanumeric characters except hyphens
        return slug;
    }
}
