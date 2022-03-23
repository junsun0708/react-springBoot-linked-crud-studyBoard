import React, { useState, useEffect } from "react";
import { Grid, Header } from "semantic-ui-react";
// import "./tui-grid.css";
import "tui-grid/dist/tui-grid.css";
import TUIGrid from "@toast-ui/react-grid";

const Test = props => {
    const gridRef = React.createRef();

    const handleAppendRow = () => {
        gridRef.current.getInstance().appendRow({});
    };
    /*
        const [data, setData] = useState([]);
    
        useEffect(() => {
            setData([
                {
                    ADVNM: "AE01",
                    SAE: "Yes",
                    SDATE: "2008-03-09",
                    EDATE: "2010-11-13",
                    IGRADE: "1",
                    ACT: "NA",
                    TPAE: "Yes",
                    MEDICATION: "Probable",
                    OUTCOME: "Fatal"
                },
                {
                    ADVNM: "AE02",
                    SAE: "No",
                    SDATE: "2005-01-11",
                    EDATE: "2006-03-03",
                    IGRADE: "2",
                    ACT: "Dose Reduced",
                    TPAE: "No",
                    MEDICATION: "Probable",
                    OUTCOME: "Recovered"
                }
            ]);
        }, []);
    
        const columns = [
            { name: "ADVNM", header: "Adverse Event", editor: "text" },
            {
                name: "SAE",
                header: "SAE",
                formatter: "listItemText",
                onBeforeChange(ev) {
                    console.log("Before change:" + ev);
                },
                onAfterChange(ev) {
                    console.log("After change:" + ev);
                },
                editor: {
                    type: "select",
                    options: {
                        listItems: [
                            { text: "Select SAE", value: "NONE" },
                            { text: "Yes", value: "YES" },
                            { text: "No", value: "NO" }
                        ]
                    }
                }
            },
            {
                name: "SDATE",
                header: "Start Date",
                align: "center",
                editor: "datePicker"
            },
            {
                name: "EDATE",
                header: "End Date",
                align: "center",
                editor: "datePicker"
            },
            { name: "IGRADE", header: "Intensity\n Grade" },
            { name: "ACT", header: "Action Takena" },
            { name: "TPAE", header: "Treatment/Procedure for AE" },
            { name: "MEDICATION", header: "Relationship to study medication" },
            { name: "OUTCOME", header: "Outcome" }
        ];
    */


    const data = {
        api: {
            readData: { url: '/user/readData', method: 'GET', initParams: { param: 'param' } }
        }
    };

    const columns = [
        { header: "USID", name: "usid" }
        , {
            header: "이름", name: "name", sortingType: 'desc', sortable: true
        }
        , { header: "부서", name: "dept" }
        , { header: "팀", name: "team" }
        , { header: "담당업무", name: "duty_c" }
        , { header: "이메일", name: "email" }
        , { header: "전화번호", name: "phone_number" }
    ];

    const rowHwaderAttr = [{ type: "checkbox" }, { type: "rowNum" }];

    return (
        <>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={8} textAlign="left" verticalAlign="middle">
                        <Header as="h2"> Adverse Event </Header>
                    </Grid.Column>
                    <Grid.Column textAlign="right" width={8}>
                        <button onClick={handleAppendRow}>Append Row</button>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
            <TUIGrid
                ref={gridRef}
                data={data}
                rowHeaders={rowHwaderAttr}
                columns={columns}
                virtualScrolling={true}
                heightResizable={false}
                usageStatistics={false}
                width={"auto"}
            />
        </>
    );
};

export default Test;
