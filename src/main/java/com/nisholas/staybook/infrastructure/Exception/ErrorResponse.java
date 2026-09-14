package com.nisholas.staybook.infrastructure.Exception;

public record ErrorResponse(int status,
                            String error,
                            String message,
                            String path) {
}
