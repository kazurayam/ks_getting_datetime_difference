package com.kazurayam.ks.time

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

public class UserExtensions {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm")
	
	static LocalDateTime toLocalDateTime(String text) {
		return LocalDateTime.parse(text, formatter)
	}
	
	static long betweenMillis(LocalDateTime start, LocalDateTime end) {
		return ChronoUnit.MILLIS.between(start, end)
	}
	
	static long betweenSeconds(LocalDateTime start, LocalDateTime end) {
		return betweenMillis(start, end) / (1000)
	}
	
	static long betweenMinutes(LocalDateTime start, LocalDateTime end) {
		return betweenMillis(start, end) / (1000 * 60)
	}
	
	static long betweenHours(LocalDateTime start, LocalDateTime end) {
		return betweenMillis(start, end) / (1000 * 60 * 60)
	}
}
