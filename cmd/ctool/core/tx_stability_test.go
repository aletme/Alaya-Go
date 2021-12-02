// Copyright 2021 The Alaya Network Authors
// This file is part of Alaya-Go.
//
// Alaya-Go is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Alaya-Go is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Alaya-Go. If not, see <http://www.gnu.org/licenses/>.


package core

import (
	"testing"
)

func TestPrepareAccount(t *testing.T) {
	//parseConfigJson(configPath)
	//err := PrepareAccount(10, pkFilePath, "0xDE0B6B3A7640000")
	//if err != nil {
	//	t.Fatalf(err.Error())
	//}
}

func TestStressTest(t *testing.T) {
	parseConfigJson(configPath)
	err := StabilityTest(pkFilePath, 1, 10)
	if err != nil {
		t.Fatalf(err.Error())
	}
}
