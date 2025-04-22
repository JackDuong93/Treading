package com.jack.model;

import com.jack.domain.VerificationType;


import lombok.Data;

@Data
public class TwoFactorAuth {

	private boolean isEnalbed = false;
	private VerificationType sendTo;
}
