package com.eoi.nutriplanner.services;

import com.eoi.nutriplanner.models.DetalleCompra;
import com.eoi.nutriplanner.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIService {

    private final OpenAiChatModel chatModel;

    public String generate(String message) {
        return  chatModel.call(message);
    }

}
