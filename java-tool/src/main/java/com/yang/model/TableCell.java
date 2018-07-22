package com.yang.model;

import lombok.*;
import org.apache.poi.ss.usermodel.CellStyle;

@Data
@AllArgsConstructor
public class TableCell {

    private Integer firstRow;

    private Integer lastRow;

    private Integer firstCol;

    private Integer lastCol;

    private String value;

    private boolean needMerge;

    private CellStyle style;
}
