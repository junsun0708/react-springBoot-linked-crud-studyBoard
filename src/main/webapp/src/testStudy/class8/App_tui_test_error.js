import React, { useRef } from "react";

import "tui-grid/dist/tui-grid.css";
import Grid from "@toast-ui/react-grid";
import TuiGrid from "tui-grid";

TuiGrid.applyTheme("striped"); // "default" or "striped" or "clean"

class CustomTextEditor {
    constructor(props) {
        const el = document.createElement('input');
        const { maxLength } = props.columnInfo.editor.options;

        el.type = 'text';
        el.maxLength = maxLength;
        el.value = String(props.value);

        this.el = el;
    }

    getElement() {
        return this.el;
    }

    getValue() {
        return this.el.value;
    }

    mounted() {
        this.el.select();
    }
};

/*
const DATA = [
    { id: 1, text: "Editor" },
    { id: 2, text: "Grid" },
    { id: 3, text: "Chart" }
];
*/
const DATA = {
    contentType: 'application/json',
    api: {
        readData: { url: '/user/readData', method: 'GET', initParams: { param: 'param' } },
        createData: { url: '/user/createData', method: 'POST' },
        updateData: { url: '/user/updateData', method: 'PUT' },
        modifyData: { url: '/user/modifyData', method: 'PUT' },
        deleteData: { url: '/user/deleteData', method: 'DELETE' }
    },
    data: {

        usid: 'test0101',
        name: '김이정',
        dept: '3',
        team: '4',
        duty_c: '55',
        email: '312D',
        phone_number: ''

    }
};

const COLUMNS = [
    /* {
         name: "id", header: "ID"
         , editor: 'text'
     },
     {
         name: "text", header: "text edit"
         , editor: {
             type: CustomTextEditor,
             options: {
                 maxLength: 10
             }
         }
     }*/
    { header: "USID", name: "usid", editor: 'text' }
    , {
        header: "이름", name: "name", sortingType: 'desc', sortable: true, editor: 'text'
    }
    , { header: "부서", name: "dept", editor: 'text' }
    , { header: "팀", name: "team", editor: 'text' }
    , { header: "담당업무", name: "duty_c", editor: 'text' }
    , { header: "이메일", name: "email", editor: 'text' }
    , { header: "전화번호", name: "phone_number", editor: 'text' }
];

/*
    const appendBtn = document.getElementById('appendBtn');
    const prependBtn = document.getElementById('prependBtn');

    const appendedData = {
      name: 'Music',
      artist: 'Lee',
      type: 'Deluxe',
      release: '2019.09.09',
      genre: 'Pop'
    };

    appendBtn.addEventListener('click', () => {
      grid.appendRow(appendedData);
    });

    prependBtn.addEventListener('click', () => {
      grid.prependRow(appendedData);
    });

*/
export default function App() {
    const gridRef = useRef();

    /* function handleAppendRow() {
         const rowCount = gridRef.current.getInstance().getRowCount();
         console.log(rowCount);
         const rowData = { id: rowCount + 1, text: "Chart" };
         const options = { focus: true };
         gridRef.current.getInstance().appendRow(rowData, options);
     }
 
     function handleDeleteRow() {
         const selectedRows = gridRef.current.getInstance().getCheckedRows();
         console.log(selectedRows);
         for (let i = 0; i < selectedRows.length; i++) {
             const selectedRow = selectedRows[i];
             console.log(selectedRow);
             gridRef.current.getInstance().removeRow(selectedRow.rowKey);
         }
     }
 
     function handleModifyRow() {
         const selectedRows = gridRef.current.getInstance().getCheckedRows();
         console.log(selectedRows);
         for (let i = 0; i < selectedRows.length; i++) {
             const selectedRow = selectedRows[i];
             console.log(selectedRow);
             gridRef.current.getInstance().removeRow(selectedRow.rowKey);
         }
     }*/

    function selectOneRowData() {
        /*
        const selectedRows = gridRef.current.getInstance().getCheckedRows();
        //for (let i = 0; i < selectedRows.length; i++) {
        console.log(gridRef.current.getInstance());
        const selectedRow = selectedRows[0];
        //}
        console.log(selectedRow);
        return selectedRow;
        */
        const appendedData = {
            usid: 'test0101',
            name: '김이정',
            dept: '3',
            team: '4',
            duty_c: '55',
            email: '312D',
            phone_number: ''
        };
        return appendedData;
    }

    function selectOneRowUpdateData() {
        const updatedData = {
            usid: 'test0101',
            name: '김23정',
            dept: '5',
            team: '3',
            duty_c: '55',
            email: '312D',
            phone_number: ''
        };
        return updatedData;
    }



    function handleAppendRow() {
        const rowData = selectOneRowData();
        const options = { focus: true };
        gridRef.current.getInstance().appendRow(rowData, options);
        gridRef.current.getInstance().request('createData');
    }

    function handleDeleteRow() {
        const selectedRows = gridRef.current.getInstance().getCheckedRows();
        for (let i = 0; i < selectedRows.length; i++) {
            const selectedRow = selectedRows[i];
            gridRef.current.getInstance().removeRow(selectedRow.rowKey);
        }
        gridRef.current.getInstance().request('deleteData');
    }

    function handleModifyRow(object) {
        //selectOneRowData();
        const rowData = selectOneRowUpdateData();
        //gridRef.current.getInstance().resetData();
        //console.log(gridRef.current.getInstance());
        //console.log(gridRef.current.getInstance().getData());
        //gridRef.current.getInstance().resetData(rowData);
        gridRef.current.getInstance().request('updateData');
    }
    /*
        Grid.on('beforeChange', ev => {
            console.log('before change:', ev);
        });
        Grid.on('afterChange', ev => {
            console.log('after change:', ev);
        });
        */
    //Grid.resetData(gridData);

    return (
        <>
            <button onClick={handleAppendRow}>추가</button>
            <button onClick={handleDeleteRow}>삭제</button>
            <button onClick={handleModifyRow}>편집</button>
            <Grid
                ref={gridRef}
                data={DATA}
                columns={COLUMNS}
                rowHeight={25}
                rowHeaders={[{ type: "checkbox" }, { type: "rowNum" }]}
                scrollX={false}
                bodyHeight={400}

            /*  editingEvent={(afterChange) => {
                  console.log("test");
              }}*/

            />
        </>
    );
}
