package com.james.api.board;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    private Long id;
    private String boardName;
    private String boardType;

    @Builder(builderMethodName = "builder")
    public Board(String boardName, String boardType) {
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
