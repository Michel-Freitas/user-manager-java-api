package com.usermanager.api.infra.response;

import java.time.Instant;
import java.util.List;

public record ErrorResponse(Instant timestamp, int status, List<String> errors) {}
